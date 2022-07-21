package com.MotoHack_GP.MotoHack_GP.services;

import com.MotoHack_GP.MotoHack_GP.dto.MotoRequestDto;
import com.MotoHack_GP.MotoHack_GP.models.Moto;
import com.MotoHack_GP.MotoHack_GP.repositories.IMotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService implements IMotoService {
    private IMotoRepository motoRepository;

    public MotoService(IMotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    @Override
    public List<Moto> getAll() {
        return motoRepository.findAll();
    }

    @Override
    public Moto getById(Long id) {
        return motoRepository.findById(id).get();
    }

    @Override
    public List<Moto> getBySearch(String search) {
        var searchList = motoRepository.findMotosBySearchOfBrandOrModel(search);
        return searchList;
    }

    @Override
    public Moto update(MotoRequestDto motoDto, Long id) {
        var motoToEdit = motoRepository.findById(id).get();
        motoToEdit.setIsFavorite(motoDto.getIsFavorite());
        return motoRepository.save(motoToEdit);
    }
}
