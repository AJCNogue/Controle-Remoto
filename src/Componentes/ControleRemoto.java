package Componentes;

public class ControleRemoto implements Controlador {
    private int volume;
    private boolean ligar;
    private boolean tocando;

    public ControleRemoto() {
        this.volume = 50;
        this.ligar = false;
        this.tocando = false;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume( int volume ) {
        this.volume = volume;
    }

    public boolean getLigar() {
        return ligar;
    }

    public void setLigar( boolean ligar ) {
        this.ligar = ligar;
    }

    public boolean getTocando() {
        return tocando;
    }

    public void setTocando( boolean tocando ) {
        this.tocando = tocando;
    }

    @Override
    public void ligar() {
        this.setLigar(true);

    }

    @Override
    public void desligar() {
        this.setLigar(false);
        this.setVolume(0);
    }

    @Override
    public void abrirMenu() {
        System.out.println("----- MENU -----");
        System.out.println("Ligado: "+ this.getLigar());
        System.out.println("Tocando: "+ this.getTocando());
        System.out.print("Volume: ");
        for (int i = 1; i <= this.getVolume(); i+=10) {
            System.out.print(" |");
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("\nFechando Menu...");
    }

    @Override
    public void maisVolume() {
        if (this.getLigar()) {
            this.setVolume(this.getVolume() + 10);
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigar() && this.getVolume() > 0) {
            this.setVolume(this.getVolume() - 10);
        } else {
            System.out.println("Impossível diminuir volume");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigar() && getVolume() > 0) {
            this.setVolume(0);
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigar() && getVolume() == 0) {
            this.setVolume(50);
        }
    }

    @Override
    public void play() {
        if (this.getLigar() && !(this.getTocando())) {
            this.setTocando(true);
        } else {
            System.out.println("Não consegui reproduzir");
        }
    }

    @Override
    public void pause() {
        if (this.getLigar() && this.getTocando()) {
            this.setTocando(false);
            this.setVolume(0);
        } else {
            System.out.println("Não consegui pausar");
        }
    }
}
