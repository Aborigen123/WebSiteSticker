package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.entity.HistorySell;
import web.repository.HistorySellRepository;
import web.service.HistorySellService;

@Service
public class HistorySellServiceImpl implements HistorySellService {

	@Autowired HistorySellRepository historySellRepository;
	
	@Override
	public void saveHistorySell(HistorySell historySell) {
		historySellRepository.save(historySell);
		
	}

	@Override
	public List<HistorySell> findAllHistorySell() {
		
		return historySellRepository.findAll();
	}

	@Override
	public HistorySell findHistorySellById(int id) {
	
		return historySellRepository.findOne(id);
	}

	@Override
	public HistorySell findParticularUserHistoryBuy(String userBuy) {
		
		return historySellRepository.findParticularUserHistoryBuy(userBuy);
	}

}
