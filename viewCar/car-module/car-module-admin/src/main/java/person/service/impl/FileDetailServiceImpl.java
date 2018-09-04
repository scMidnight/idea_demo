package person.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.service.FileDetailService;

@Service("fileDetailService")
@Transactional
public class FileDetailServiceImpl extends CommonServiceImpl implements FileDetailService {
}
