package com.cogitech.cyberax.service.impl;

import com.cogitech.cyberax.service.GagnantService;
import com.cogitech.cyberax.domain.Gagnant;
import com.cogitech.cyberax.repository.GagnantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Gagnant}.
 */
@Service
@Transactional
public class GagnantServiceImpl implements GagnantService {

    private final Logger log = LoggerFactory.getLogger(GagnantServiceImpl.class);

    private final GagnantRepository gagnantRepository;

    public GagnantServiceImpl(GagnantRepository gagnantRepository) {
        this.gagnantRepository = gagnantRepository;
    }

    /**
     * Save a gagnant.
     *
     * @param gagnant the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Gagnant save(Gagnant gagnant) {
        log.debug("Request to save Gagnant : {}", gagnant);
        return gagnantRepository.save(gagnant);
    }

    /**
     * Get all the gagnants.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Gagnant> findAll(Pageable pageable) {
        log.debug("Request to get all Gagnants");
        return gagnantRepository.findAll(pageable);
    }


    /**
     * Get one gagnant by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Gagnant> findOne(Long id) {
        log.debug("Request to get Gagnant : {}", id);
        return gagnantRepository.findById(id);
    }

    /**
     * Delete the gagnant by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Gagnant : {}", id);
        gagnantRepository.deleteById(id);
    }
}
