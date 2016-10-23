package jp.ahaha.goodWeather.Model.Repository;

import jp.ahaha.goodWeather.Model.DataBase.SampleDbDef;

import javax.persistence.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sampledb")
public class sampleDbRepo extends HttpServlet {
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    long idVal = 0L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        entityManagerFactory = Persistence.createEntityManagerFactory("goodweather");
        entityManager = entityManagerFactory.createEntityManager();
        SampleDbDef sample = new SampleDbDef();
        sample.setId(idVal++);
        sample.name = "data";
        entityManager.getTransaction().begin();
        entityManager.persist(sample);
        entityManager.getTransaction().commit();
        response.getWriter().println("Data Commit DONE!!!" + idVal);
    }
}
