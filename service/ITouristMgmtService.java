package in.priyankait.service;

import java.util.List;

import in.priyankait.entity.Tourist;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist>fetchAllTourists();
	public Tourist getTouristById(Integer id);

}

