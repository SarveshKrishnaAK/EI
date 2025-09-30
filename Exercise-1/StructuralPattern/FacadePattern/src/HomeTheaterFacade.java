public class HomeTheaterFacade {
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;
    public HomeTheaterFacade(Projector p, SoundSystem s, Lights l) {
        this.projector = p;
        this.soundSystem = s;
        this.lights = l;
    }
    public void watchMovie() {
        lights.dim();
        projector.on();
        soundSystem.on();
        System.out.println("Movie started!");
    }
    public void endMovie() {
        projector.off();
        soundSystem.off();
        lights.on();
        System.out.println("Movie ended!");
    }
}
