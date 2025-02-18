package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Playlist;
import com.example.demo.service.PlaylistService;



@Controller
public class AdminController {
	
private static final String ADMIN_USERNAME = "Admin";
    
    private static final String ADMIN_PASSWORD = "Admin@123";
    
    @Autowired
    private PlaylistService playlistservice;
    
    @GetMapping("/Admin/login")
    public String showAdminLogin() {
        return "Admin/adminLogin";
    }
    
    @PostMapping("/Admin/login")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return "redirect:/Admin/products";
        } else {
            model.addAttribute("error", "Invalid username and password");
            return "Admin/adminLogin";
        }
    }
    
    @GetMapping("/Admin/products/add")
    public String showAddPlaylistForm(Model model) {
        model.addAttribute("playlist", new Playlist());
        return "Admin/add-products";
    };
    
    @PostMapping("/Admin/products/add")
    public String addPlaylist(@ModelAttribute Playlist playlist) {
        playlistservice.savePlaylist(playlist);
        return "redirect:/Admin/products";
    }
    
    @GetMapping("/Admin/products")
    public String showAdminProducts(Model model) {
        List<Playlist> products = playlistservice.findAllPlaylist();
        model.addAttribute("products", products);
        return "Admin/products";
    }
    
    @GetMapping("/Admin/products/delete")
    public String deletePlaylist(@RequestParam("id") Long id) {
        playlistservice.deletePlaylist(id);
        return "redirect:/Admin/products";
    }
}

