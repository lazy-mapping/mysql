package hello01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cd.xml")
public class CdPlayerTest {
	  @Autowired
	 private CompactDiscs CompactDiscs1;
	  @Autowired
	  private CdPlayer cdPlayer1;//应用于多个对象时，id只有一个,name可以有多个
	  
	@Test//普通单元测试
	public void testPlay01() {
		  CompactDiscs1.play();
		  cdPlayer1.play();
	}

}
/*
<!-- <bean name="compactDiscs1" class="hello01.CompactDiscs">
<constructor-arg index="0" value="I Do" />
<constructor-arg index="1" value="莫文蔚" />
</bean>
<bean name="compactDiscs2" class="hello01.CompactDiscs"/>

<bean id="cdPlayer1" class="hello01.CdPlayer">
	  <constructor-arg ref="compactDiscs1" />
</bean>
<bean id="cdPlayer2" class="hello01.CdPlayer" c:mp-ref="compactDiscs2"/> -->*/
/* <constructor-arg>的构造函数注入依赖*/