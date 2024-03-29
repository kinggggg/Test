//package com.zeek.pattern.test.factory.simplefactory;
//
//public class RuleConfigSource2 {
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
//    public static IRuleConfigParser createParser(String configFormat) {
//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(configFormat)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(configFormat)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(configFormat)) {
//            parser = new PropertiesRuleConfigParser();
//        }
//        return parser;
//    }
//}