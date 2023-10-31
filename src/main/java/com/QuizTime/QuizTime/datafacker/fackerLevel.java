package com.QuizTime.QuizTime.datafacker;

import com.QuizTime.QuizTime.model.entity.Level;
import com.QuizTime.QuizTime.repository.levelRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class fackerLevel {

    private final Faker faker;
    private final levelRepository Repolevel;

    @Autowired
    public fackerLevel(Faker faker, levelRepository Repolevel){
        this.faker = faker;
        this.Repolevel = Repolevel;
    }

    public void populateLevelsWithFackerData(int numbersOfRecords) {
        List<Level> levels = new ArrayList<>();

        for(int i = 0; i < numbersOfRecords; i++){
            Level level = new Level();

            /*
            DecimalFormat df = new DecimalFormat("#.##");
            double maxPoints = faker.random().nextDouble(1, 5);
            level.setMaxPoints(Double.parseDouble(df.format(maxPoints)));
             */

            level.setDescription(faker.lorem().sentence());
            double maxPoints = faker.random().nextDouble(1, 5);
            level.setMaxPoints(maxPoints);
            double minPoints = faker.random().nextDouble(0, maxPoints);
            level.setMinPoints(minPoints);

            levels.add(level);
        }
        Repolevel.saveAll(levels);
    }

}
