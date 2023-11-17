package net.isntz.ugelium.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.isntz.ugelium.Ugelium;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.item.ModItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class UgeliumFusingCategory implements DisplayCategory<BasicDisplay> {
   public static final Identifier TEXTURE =
           new Identifier(Ugelium.MOD_ID,"textures/gui/ugelium_fuser_gui.png");
   public static final CategoryIdentifier<UgeliumFusingDisplay> UGELIUM_FUSING =
           CategoryIdentifier.of(Ugelium.MOD_ID, "ugelium_fusing");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return UGELIUM_FUSING;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Ugelium Fuser");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.UGELIUM_FUSER.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        final Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() -35);
        List<Widget> widgets = new LinkedList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 175, 82)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 69, startPoint.y + 11))
                .entries(display.getInputEntries().get(0)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 92, startPoint.y + 11))
                .entries((Collection<? extends EntryStack<?>>) ModItem.UGELIUM));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 59))
                .markOutput().entries(display.getOutputEntries().get(0)));

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }
}
