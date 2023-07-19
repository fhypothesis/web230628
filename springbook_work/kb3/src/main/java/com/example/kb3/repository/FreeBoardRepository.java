package com.example.kb3.repository;

import com.example.kb3.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreeBoardRepository extends JpaRepository<FreeBoard,Integer> {

    // select * from freeboard where title like '%title%' or content like '%content%' limint 0,5 ;

    Page<FreeBoard> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
//    @Query("select board from FreeBoard where idx=?1")
//    FreeBoard myQuery(int idx);
}
