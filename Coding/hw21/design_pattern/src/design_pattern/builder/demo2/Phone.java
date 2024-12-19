package design_pattern.builder.demo2;

public class Phone {
    private String cpu;
    private String screen;
    private String memory;
    private String motherBoard;

    private Phone(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.motherBoard = builder.motherBoard;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", motherBoard='" + motherBoard + '\'' +
                '}';
    }

    public static final class Builder {
        private String cpu;
        private String screen;
        private String memory;
        private String motherBoard;

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }
        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }
        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }
        public Builder motherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}
