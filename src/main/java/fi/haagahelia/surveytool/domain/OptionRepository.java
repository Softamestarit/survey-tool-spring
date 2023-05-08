package fi.haagahelia.surveytool.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long>{
	
	List<Option> findAllByOptionId(Long optionId);

}