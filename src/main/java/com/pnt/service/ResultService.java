package com.pnt.service;

import java.util.List;

import com.pnt.model.dto.ResultDto;
import com.pnt.model.result.Result;

public interface ResultService {
	public Result addResult(Result result);
	public Result updateResult(Result result);
	public List<Result> getAllResult();
	public List<ResultDto> getTotalPointExport();
	public void deleteResult(Long id);
}
