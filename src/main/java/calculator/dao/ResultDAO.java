package calculator.dao;

import calculator.models.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ResultDAO {

    public List<Result> results=new ArrayList<>();

    public void addResult(Result result) {
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }




}
