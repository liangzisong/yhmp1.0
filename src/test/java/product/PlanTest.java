package product;

import java.util.List;

import org.junit.Test;

import com.yhmp.project.entity.PreservationProjectVO;
import com.yhmp.project.service.PreservationProjecServer;

public class PlanTest extends TestBean {

	@Test
	public void Test(){
	    PreservationProjecServer declareServer = ctx.getBean("preservationProjecServerImpl", PreservationProjecServer.class);
	    PreservationProjectVO p = new PreservationProjectVO();
	    p.setDeclareProject("基础测绘项目");
	    List<PreservationProjectVO> list = declareServer.selectPreservationProject(p);
	    list.forEach(System.out::println);
	}
}
