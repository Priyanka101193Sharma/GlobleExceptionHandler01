package in.priyankait.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.priyankait.entity.Tourist;
import in.priyankait.exception.TouristNotFoundException;
import in.priyankait.repo.ITouristRepo;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is registerd having the id value::"+idVal;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist>list=touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}
	@Override
	public Tourist getTouristById(Integer id) {
		Optional<Tourist> opt = touristRepo.findById(id);
		if(opt.isPresent()) {
			Tourist tourist = opt.get();
			return tourist;
		}
		else throw new TouristNotFoundException("tourist notExist by this Id");
	}

}
