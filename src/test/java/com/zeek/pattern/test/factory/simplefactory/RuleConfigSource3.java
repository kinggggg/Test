//package com.zeek.pattern.test.factory.simplefactory;
//
//public class RuleConfigSource3 {
//
//    public class RuleConfigSource {
//        public RuleConfig load(String ruleConfigFilePath) {
//            String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
//            IRuleConfigParser parser = RuleConfigParserFactory.createParser(ruleConfigFileExtension);
//            if (parser == null) {
//                throw new InvalidRuleConfigException(
//                        "Rule config file format is not supported: " + ruleConfigFilePath);
//            }
//
//            String configText = "";
//            //从ruleConfigFilePath文件中读取配置文本到configText中
//            RuleConfig ruleConfig = parser.parse(configText);
//            return ruleConfig;
//        }
//
//        private String getFileExtension(String filePath) {
//            //...解析文件名获取扩展名，比如rule.json，返回json
//            return "json";
//        }
//    }
//}
//
//class RuleConfigParserFactory {
//    private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();
//
//    static {
//        cachedParsers.put("json", new JsonRuleConfigParser());
//        cachedParsers.put("xml", new XmlRuleConfigParser());
//        cachedParsers.put("yaml", new YamlRuleConfigParser());
//        cachedParsers.put("properties", new PropertiesRuleConfigParser());
//    }
//
//    public static IRuleConfigParser createParser(String configFormat) {
//        if (configFormat == null || configFormat.isEmpty()) {
//            return null;//返回null还是IllegalArgumentException全凭你自己说了算
//        }
//        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
//        return parser;
//    }
//}