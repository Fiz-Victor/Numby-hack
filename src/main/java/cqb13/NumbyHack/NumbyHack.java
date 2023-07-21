package cqb13.NumbyHack;

import com.mojang.logging.LogUtils;
import cqb13.NumbyHack.hud.ItemCounter;
import cqb13.NumbyHack.hud.TextRadarHud;
import cqb13.NumbyHack.modules.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;
import org.slf4j.Logger;

public class NumbyHack extends MeteorAddon {
    public static final Category CATEGORY = new Category("Numby Hack", Items.TURTLE_HELMET.getDefaultStack());
    public static final HudGroup HUD_GROUP = new HudGroup("Numby Hack");
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        Log("Beginning initialization.");

        Log("Adding modules...");
        Modules.get().add(new AutoLogPlus());
        Modules.get().add(new BetterPlace());
        Modules.get().add(new Beyblade());
        Modules.get().add(new ConditionToggle());
        Modules.get().add(new Confetti());
        Modules.get().add(new GameSettings());
        Modules.get().add(new IgnoreDeaths());
        Modules.get().add(new JumpHelper());
        Modules.get().add(new NoStrip());
        Modules.get().add(new RideStats());
        Modules.get().add(new SafeFire());
        Modules.get().add(new SafetyNet());

        Log("Adding HUD modules...");
        Hud.get().register(ItemCounter.INFO);
        Hud.get().register(TextRadarHud.INFO);

        Log("Initialized successfully!");
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "cqb13.NumbyHack";
    }

    public static void Log(String text) {
        LOGGER.info(text);
    }
}
