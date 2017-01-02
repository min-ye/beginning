package com.lia.beginning.spring.embeddeddatabase;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.lia.beginning.spring.embeddeddatabase.model.Brick;
import com.lia.beginning.spring.embeddeddatabase.data.BrickRepository;
import com.lia.beginning.spring.embeddeddatabase.data.jdbc.BrickRepositoryImp;
import com.lia.beginning.spring.embeddeddatabase.config.JDBCConfig;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(JDBCConfig.class);
        BrickRepository brickRepository = (BrickRepository) context.getBean("brickRepository");

        Long count = brickRepository.count();
        System.out.println(count);

        Long colorId = 1L;
        Long categoryId = 1L;

        Brick brick = new Brick(null, "2", "2", "brick2", colorId, categoryId, "url2");
        brickRepository.save(brick);
        count = brickRepository.count();

        brick = brickRepository.fetchById(1L);
        System.out.println(count);
        String output = String.format("%s - %s - %s", brick.getElementCode(), brick.getDesignCode(), brick.getImageUrl());
        System.out.println(output);
    }
}
