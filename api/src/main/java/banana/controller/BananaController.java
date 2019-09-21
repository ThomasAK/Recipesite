package banana.controller;

import banana.entity.BananaData;

import banana.service.BananaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/banana")
@RestController
public class BananaController {
    private BananaService bananaService;
    @Autowired
    public BananaController(BananaService bananaService) {
        this.bananaService = bananaService;
    }

    @GetMapping
    public List<BananaData> list(@RequestParam(defaultValue = "0")Integer pageNumber,
                                @RequestParam(defaultValue = "10")Integer pageSize
                           ){
        return bananaService.list(pageNumber,pageSize);
    }

    @PostMapping
    public BananaData create(@RequestBody BananaData bananaData){
        return bananaService.save(bananaData);
    }

    @GetMapping("/{id}")
    public BananaData read(@PathVariable Integer id){
        return bananaService.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        bananaService.delete(id);
    }
}
