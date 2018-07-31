package product;

import java.time.LocalDate;

import org.junit.Test;

public class PlanServerImplTest extends TestBean {

    @Test
    public void addPrjectPlanTest() {
//        PlanServerImpl planServerImpl = ctx.getBean("planServerImpl", PlanServerImpl.class);
//        ProjectPlan projectPlan = new ProjectPlan();
//        planServerImpl.addPrjectPlan(projectPlan);
        LocalDate localData = LocalDate.now();
        System.out.println(localData);
    }
}
