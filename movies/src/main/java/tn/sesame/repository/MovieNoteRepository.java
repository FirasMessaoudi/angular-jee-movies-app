package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.sesame.model.MovieNote;
import tn.sesame.model.ProductUserID;

public interface MovieNoteRepository extends JpaRepository<MovieNote, ProductUserID> {
    @Query("select sum(m.note) / count (m.note) from MovieNote m where m.productUserID.idProduct=:x")
    public double getMovieNote(@Param("x") Long idProduct);
}
