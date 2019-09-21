package banana.service;

import banana.entity.BananaData;
import banana.repository.BananaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BananaService {
    private BananaDataRepository repository;
    @Autowired
    public BananaService(BananaDataRepository repository){
        this.repository = repository;
    }
    public BananaData save(BananaData bananaData){
        return repository.save(bananaData);
    }
    public List<BananaData> list(int pageNumber,int pageSize){
        return repository.findAll(PageRequest.of(pageNumber,pageSize)).getContent();
    }
    public BananaData find(int waffle){
        return repository.findById(waffle).orElse(null);
    }
    public void delete(int waffle){
        repository.deleteById(waffle);
    }
}
