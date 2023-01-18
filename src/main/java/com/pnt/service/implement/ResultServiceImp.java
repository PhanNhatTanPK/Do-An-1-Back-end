package com.pnt.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pnt.model.dto.ResultDto;
import com.pnt.model.result.Result;
import com.pnt.repository.ResultDtoRepo;
import com.pnt.repository.ResultRepo;
import com.pnt.service.ResultService;

@Service
public class ResultServiceImp implements ResultService{
	@Autowired
	private ResultRepo resultRepo;
	@Autowired
	private ResultDtoRepo resultDtoRepo;
	
	@Override
	public Result addResult(Result result) {
		// TODO Auto-generated method stub
		return this.resultRepo.save(result);
	}

	@Override
	public Result updateResult(Result result) {
		// TODO Auto-generated method stub
		return this.resultRepo.save(result);
	}

	@Override
	public List<Result> getAllResult() {
		// TODO Auto-generated method stub
		return this.resultRepo.findAll();
	}

	@Override
	public void deleteResult(Long id) {
		// TODO Auto-generated method stub
		this.resultRepo.delete(id);
	}

	@Override
	public List<ResultDto> getTotalPointExport() {
		// TODO Auto-generated method stub
		return this.resultDtoRepo.getTotalPointExport();
	}

}
