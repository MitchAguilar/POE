package clook;

/**
 * @(#)ImageBackground
 */

//package es.fcocascales.relojagujas;
import java.awt.*;
import java.awt.image.*;
import static javafx.scene.paint.Color.rgb;

/**
 * Crea una imagen para colocarla de fondo
 *
 * @author Fco. Cascales
 */
public class ImageBackground extends Component {

    private Image image;
    private int width, height;
    private int[] pixels;
    private MemoryImageSource source;

    /**
     * Constructor
     */
    public ImageBackground() {
        this(25, 25);
    }

    public ImageBackground(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        drawPixels(); // Inicializa el array de pixels

        source = new MemoryImageSource(width, height, pixels, 0, width);
        //source.setAnimated (true);
        //source.setFullBufferUpdates (true);

        image = createImage(source);
    }

    /**
     * Obtener la imagen creada
     */
    public Image getImage() {
        return image;
    }

    /**
     * Degradado rojo y azul
     */
    private void drawPixels() {
        int index = 0;
        for (int j = 0; j right) {
            xPerCent = (left - (x - right)) / left;
        }

        if (y < top) {
            yPerCent = y / top;
        } else if (y > bottom) {
            yPerCent = (top - (y - bottom)) / top;
        }

        if (xPerCent != 1 || yPerCent != 1) {
            _RGB[0] = (rgb & 0xff0000) >> 16;
            _RGB[1] = (rgb & 0x00ff00) >> 8;
            _RGB[2] = (rgb & 0x0000ff);

            Color.RGBtoHSB(_RGB[0], _RGB[1], _RGB[2], _HSB);

            _HSB[2] = _HSB[2] * xPerCent * yPerCent;

            pixels[index++] = 0xff000000
                    | Color.HSBtoRGB(_HSB[0], _HSB[1], _HSB[2]);
        } else {
            pixels[index++] = rgb;
        }
    }
}


// End of File
