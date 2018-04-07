package web.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import web.domain.StickerNameFilter;
import web.entity.Sticker;
import web.entity.UserEntity;
import web.repository.StickerRepository;
import web.service.StickerService;

@Service
public class StickerServiceImpl implements StickerService{

	@Autowired StickerRepository stickerRepository;
	
	@Override
	public void saveSticker(Sticker sticker) {
		stickerRepository.save(sticker);
	}

	@Override
	public List<Sticker> findAllSticker() {
		return stickerRepository.findAll();
	}

	@Override
	public Page<Sticker> findAllStickerByPage(Pageable pageable) {
		PageRequest request = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(),pageable.getSort());
		
		return stickerRepository.findAll(request);
	}
//	@Override
//	public void random() {
//		
//		for(int i = 0; i<40; i++) {
//			Sticker sticker = new Sticker();
//			sticker.setName("Name #"+1);
//			
//			Sticker savedSticker = stickerRepository.save(sticker);
//			
//		}
//
//		
//	}
//	

	@Override
	public Page<Sticker> findStickerByName(Pageable pageable, StickerNameFilter filter) {
		
		return stickerRepository.findAll(getSpecification(filter), pageable);
	}
	
	private Specification<Sticker> getSpecification(StickerNameFilter filter){
		return new Specification<Sticker>() {

			@Override
			public Predicate toPredicate(Root<Sticker> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
			if(filter.getSearch().isEmpty()) return null;
				return cb.like(root.get("name"), "%" + filter.getSearch() + "%");
			}
			
			
		};
		
	}

	@Override
	public void deleteByBuy(int id) {
		 stickerRepository.delete(id);
		
	}

	@Override
	public void deleteByBuy1(Sticker sticker) {
		 stickerRepository.delete(sticker);
		
	}
	
	@Override
	public Sticker deleteBuy(int id) {
		
		Sticker sticker = stickerRepository.findOne(id);
		
		stickerRepository.delete(sticker);
		return sticker;
				 
	}

	@Override
	public Sticker findStickerById(int id) {
		return stickerRepository.findOne(id);
	}
}
