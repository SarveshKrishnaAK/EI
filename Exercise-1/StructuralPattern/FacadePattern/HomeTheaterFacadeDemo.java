// Main method for Facade Pattern Demo
public class HomeTheaterFacadeDemo {
    public static void main(String[] args) {
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, soundSystem, lights);
        homeTheater.watchMovie();
        homeTheater.endMovie();
    }
}
