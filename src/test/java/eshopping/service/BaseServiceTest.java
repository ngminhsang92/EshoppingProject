package eshopping.service;

import eshopping.EshoppingTestingConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sangnguyen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {EshoppingTestingConfig.class})
@ActiveProfiles("utest")
public abstract class BaseServiceTest {

}
