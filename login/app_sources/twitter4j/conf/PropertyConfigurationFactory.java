package twitter4j.conf;

/* loaded from: classes4.dex */
class PropertyConfigurationFactory implements ConfigurationFactory {
    private static final PropertyConfiguration ROOT_CONFIGURATION = new PropertyConfiguration();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationFactory
    public void dispose() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PropertyConfigurationFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationFactory
    public Configuration getInstance() {
        return ROOT_CONFIGURATION;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationFactory
    public Configuration getInstance(String str) {
        PropertyConfiguration propertyConfiguration = new PropertyConfiguration(str);
        propertyConfiguration.dumpConfiguration();
        return propertyConfiguration;
    }
}
