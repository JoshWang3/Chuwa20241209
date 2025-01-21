package org.chuwa.iocdi;

import org.springframework.stereotype.Service;

@Service
public interface AmbiguityService {
    String getServiceType();
}

@Service("primaryService")
class PrimaryService implements AmbiguityService {
    @Override
    public String getServiceType() {
        return "Primary Service";
    }
}

@Service("secondaryService")
class SecondaryService implements AmbiguityService {
    @Override
    public String getServiceType() {
        return "Secondary Service";
    }
}
