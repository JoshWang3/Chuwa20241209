package Advanced.DesignPattern.Builder;

// Builder interface
public interface Builder {
    void buildCPU();
    void buildRAM();
    void buildStorage();
    Computer getResult();
}

