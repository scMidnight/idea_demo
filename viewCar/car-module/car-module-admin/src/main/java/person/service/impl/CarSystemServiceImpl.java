package person.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.service.CarSystemService;

/**
 * Created by SunChang on 2018/8/27
 */
@Service("carService")
@Transactional
public class CarSystemServiceImpl extends CommonServiceImpl implements CarSystemService {
}
