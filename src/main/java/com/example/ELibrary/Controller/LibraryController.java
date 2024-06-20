package com.example.ELibrary.Controller;

import com.example.ELibrary.Model.Library1;
import com.example.ELibrary.Model.Student;
import com.example.ELibrary.Service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    LibraryService libraryService;
    @PostMapping("/in/{stId}")
    public String inEntry(@PathVariable String stId){
        return libraryService.InEntry(stId);
    }

    @DeleteMapping("/out/{stId}")
    public void deleteLibrary1(@PathVariable String stId) {
         libraryService.deleteLibrary1(stId);
        // libraryService.outEntry(stId);
    }

//    @PostMapping("/{stId}")
//    public String outEntry(@PathVariable String stId){
//        return libraryService.outEntry(stId);
//    }

    @GetMapping("/find/{stId}")
    public Library1 getStudentByStId(@PathVariable String stId){
        return libraryService.getStudentByStId(stId);
    }
    @GetMapping("/allStudent")
    public List<Library1> getAllLibraries(){
        return libraryService.getAllLibraries();
    }
}
