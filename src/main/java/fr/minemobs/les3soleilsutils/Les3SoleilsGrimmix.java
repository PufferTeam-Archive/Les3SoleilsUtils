package fr.minemobs.les3soleilsutils;

import io.github.crucible.grimoire.common.api.grimmix.Grimmix;
import io.github.crucible.grimoire.common.api.grimmix.GrimmixController;
import io.github.crucible.grimoire.common.api.grimmix.lifecycle.IConfigBuildingEvent;

@Grimmix(id = "les3soleilsgrimmix", name = "Les3Soleils Grimmix")
public class Les3SoleilsGrimmix extends GrimmixController {

    @Override
    public void buildMixinConfigs(IConfigBuildingEvent event) {
        event.createBuilder(String.format("%s/mixins.%s.json", Les3SoleilsUtils.MODID, Les3SoleilsUtils.MODID))
                .mixinPackage("fr.minemobs.les3soleilsutils.mixin")
                .clientMixins("client.*")
                .refmap("@MIXIN_REFMAP@")
                .verbose(true)
                .required(true)
                .build();
    }
}
