package Configs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteParser {

    public static SpriteParser spriteParser = null;

    private SpriteParser(){
        getSprites();
    }

    public static SpriteParser getSpriteParser(){
        if(spriteParser == null){
            spriteParser = new SpriteParser();
        }
        return spriteParser;
    }

    private BufferedImage[] tileSprites;

    public Image getIceImage(){
        return tileSprites[11*12];
    }

    public Image getWaterImage(){
        return tileSprites[5*12];
    }

    public Image getGlacierImage(){
        return tileSprites[17*12];
    }

    public Image getAreaEffectDamageImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.AREAEFFECT_DAMAGE_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getAreaEffectHealImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.AREAEFFECT_HEAL_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getAreaEffectKillImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.AREAEFFECT_KILL_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getAreaEffectLevelUpImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.AREAEFFECT_LEVELUP_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getInteractiveItemImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.ITEM_ITERACTIVE_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getOneShotItemImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.ITEM_ONESHOT_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getTakeAbleItemImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.ITEM_TAKEABLE_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getTeleporterItemImage(){
        ImageIcon imageIcon = new ImageIcon(Commons.ITEM_TELEPORTER_FILELOCATION);
        return imageIcon.getImage();
    }

    public Image getObstacleItemImage(){
        return tileSprites[7*12];
    }

    public Image getRunescapeGUI(){
        ImageIcon imageIcon = new ImageIcon(Commons.RUNESCAPE_GUI_FILELCOATION);
        return imageIcon.getImage();
    }

    private void getSprites(){
        BufferedImage bigImg = null;
        try {
            bigImg = ImageIO.read(new File(Commons.TILE_SHEET));
        } catch (IOException e) {
            e.printStackTrace();
        }

        final int width = 32;
        final int height = 32;
        final int rows = 18;
        final int cols = 12;
        tileSprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                tileSprites[(i * cols) + j] = bigImg.getSubimage(
                        j * width,
                        i * height,
                        width,
                        height
                );
            }
        }
    }

}