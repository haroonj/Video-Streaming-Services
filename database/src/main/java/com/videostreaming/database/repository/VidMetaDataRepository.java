package com.videostreaming.database.repository;

import com.videostreaming.database.entity.VidMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VidMetaDataRepository extends JpaRepository<VidMetaData, Long> {
}
