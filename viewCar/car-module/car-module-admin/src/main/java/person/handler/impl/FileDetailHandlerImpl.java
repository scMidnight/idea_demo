package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.handler.FileDetailHandler;
import person.service.FileDetailService;

@Service("fileDetailHandler")
public class FileDetailHandlerImpl implements FileDetailHandler {
    @Autowired
    FileDetailService fileDetailService;
}
