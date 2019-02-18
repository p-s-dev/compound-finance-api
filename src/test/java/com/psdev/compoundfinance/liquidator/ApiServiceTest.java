package com.psdev.compoundfinance.liquidator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class ApiServiceTest {

    ApiService api;
    String TEST_ADDRESS = "0xc88b963239b6918f74c3298bb1dc079b92671e42";
    String TEST_KEY = "";

    @Before
    public void before() {
        api = new ApiService(ApiCredentials.of(TEST_KEY));
    }

    //get_top_account_values
    @Test
    public void testGetTopAccountValues() {
        String response = api.getTopAccountValuesString();
        System.out.println(response);
        Assert.assertNotNull(response);
    }

    //{"request":{"page_size":100,"page_number":1,"min_borrow_value_in_eth":{"value":"0"},"max_collateral_ratio":{"value":"2"}},"pagination_summary":{"total_pages":1,"total_entries":56,"page_size":100,"page_number":1},"error":null,"account_values":[{"total_supply_value_in_eth":{"value":"19507121389702.00000000000000"},"total_borrow_value_in_eth":{"value":"1066532819210856.704788978240"},"block_updated":7237051,"address":"0xbd56dba641a856a0afa8dc05bfe52368965bb04b"},{"total_supply_value_in_eth":{"value":"6048898517410.000000000000000"},"total_borrow_value_in_eth":{"value":"273290505634322.9569337945607"},"block_updated":7237010,"address":"0xf7885329eb5bf341fbaa3edf34b39169527c00f8"},{"total_supply_value_in_eth":{"value":"33566219639490.63914852000000"},"total_borrow_value_in_eth":{"value":"723312217915845.4547456459942"},"block_updated":7237010,"address":"0x5bc97105c14d4fa9ba6e3bb896df283b18c2fcea"},{"total_supply_value_in_eth":{"value":"91148338513472.25064148471734"},"total_borrow_value_in_eth":{"value":"309942534837033.0544114026239"},"block_updated":7237040,"address":"0x8239ff0afb54509551b82db7199da6baa30fcd8e"},{"total_supply_value_in_eth":{"value":"263034236824924.0000000000000"},"total_borrow_value_in_eth":{"value":"297815456694297.0110386382958"},"block_updated":7237057,"address":"0xff2723785c65e51e4ac1db34e6d78d5d93fa8e68"},{"total_supply_value_in_eth":{"value":"42875828276758.71306820033337"},"total_borrow_value_in_eth":{"value":"47842286988203.00000000000000"},"block_updated":7237040,"address":"0xa96483ba4db0d09ca8197c2e7e342d93bab96b75"},{"total_supply_value_in_eth":{"value":"37071180076867.00000000000000"},"total_borrow_value_in_eth":{"value":"40850692503851.62890996677146"},"block_updated":7237027,"address":"0x94c7c5f905fc888ddc48c51a90b68ddec44f8d8c"},{"total_supply_value_in_eth":{"value":"25236871520.00000000000000000"},"total_borrow_value_in_eth":{"value":"24826188581.80603624851594626"},"block_updated":7237080,"address":"0xa6dffbc492e1dccae78bf4f6f6c13b1f96469e11"},{"total_supply_value_in_eth":{"value":"249295271894282.8208655000000"},"total_borrow_value_in_eth":{"value":"245050847771028.0000000000000"},"block_updated":7237080,"address":"0x3dbb52de7f79598e09efefc3eaef0dff1118e144"},{"total_supply_value_in_eth":{"value":"2684087923177.000000000000000"},"total_borrow_value_in_eth":{"value":"2482004612206.636761018486317"},"block_updated":7237080,"address":"0x3dc389e0a69d6364a66ab64ebd51234da9569284"},{"total_supply_value_in_eth":{"value":"84539239513840.24526486410692"},"total_borrow_value_in_eth":{"value":"76330288816027.00000000000000"},"block_updated":7237040,"address":"0x8246c3fa968b1955d8a31773acde6356663dff44"},{"total_supply_value_in_eth":{"value":"2017472636450.161271290000000"},"total_borrow_value_in_eth":{"value":"1814270766602.107056475000000"},"block_updated":7237057,"address":"0x493a9869e3b5f846f72267ab19b76e9bf99d51b1"},{"total_supply_value_in_eth":{"value":"1133976004310396.653712371977"},"total_borrow_value_in_eth":{"value":"1003275011132511.000000000000"},"block_updated":7237051,"address":"0x00eca04fe1cf81e245bb9c96aad8f165ead5be24"},{"total_supply_value_in_eth":{"value":"468945861969395.8605165100000"},"total_borrow_value_in_eth":{"value":"410261681024682.8880408125000"},"block_updated":7237040,"address":"0x57090e010139cb7a7cab63912e520e0d3f2cc5cd"},{"total_supply_value_in_eth":{"value":"27450225902793.22099424179212"},"total_borrow_value_in_eth":{"value":"23087373926252.00000000000000"},"block_updated":7237056,"address":"0x63feb32051d549a69aeb84a7db08b309b6652fee"},{"total_supply_value_in_eth":{"value":"13191063972088.47199753445745"},"total_borrow_value_in_eth":{"value":"9733051823253.474637525000000"},"block_updated":7237071,"address":"0x1231d83026c6d8fd810501801288668590ab1ce4"},{"total_supply_value_in_eth":{"value":"10218801032443.40210357756779"},"total_borrow_value_in_eth":{"value":"7527273964241.077925550000000"},"block_updated":7237080,"address":"0xc610ac3017b833337d2e68255855436d3e0ff114"},{"total_supply_value_in_eth":{"value":"3410207873417742.950235023971"},"total_borrow_value_in_eth":{"value":"2506935700026623.158692989782"},"block_updated":7237071,"address":"0xe9e62e55a3a566599909d6e97de603305500960a"},{"total_supply_value_in_eth":{"value":"29848734290127776.42563149607"},"total_borrow_value_in_eth":{"value":"20970056490515385.37358357750"},"block_updated":7237080,"address":"0xcbc98720fe2ae6294f80a9ac9e387860ae289056"},{"total_supply_value_in_eth":{"value":"597687034379446539.5647465041"},"total_borrow_value_in_eth":{"value":"411946994278257415.9025025350"},"block_updated":7237062,"address":"0x67e877e28fc0e3c92916f3f4539e04d77dff3761"},{"total_supply_value_in_eth":{"value":"20896939308658220.53127600506"},"total_borrow_value_in_eth":{"value":"14357132781164712.76695620750"},"block_updated":7237051,"address":"0x8de55c09f21aa4312d1bcba8cbef2b44eabf7f40"},{"total_supply_value_in_eth":{"value":"9802602448472594.717299177567"},"total_borrow_value_in_eth":{"value":"6717943124700006.983493210000"},"block_updated":7237040,"address":"0x4e7fe6d44ef812ce291769d21046b9d2f540b7dc"},{"total_supply_value_in_eth":{"value":"1007659763268068.000000000000"},"total_borrow_value_in_eth":{"value":"688698590072906.0000000000000"},"block_updated":7237071,"address":"0x0ac4cfbcc7dee4e7137f8af0b94ec725505fb227"},{"total_supply_value_in_eth":{"value":"48561482999187519.23170980000"},"total_borrow_value_in_eth":{"value":"33162589932058563.00000000000"},"block_updated":7237080,"address":"0x17c6f0a4016d782603e4f73a8db4ce09636728e3"},{"total_supply_value_in_eth":{"value":"62481628501034.00000000000000"},"total_borrow_value_in_eth":{"value":"42637942549039.00000000000000"},"block_updated":7237056,"address":"0xc88b963239b6918f74c3298bb1dc079b92671e42"},{"total_supply_value_in_eth":{"value":"147389127176320.0305927563758"},"total_borrow_value_in_eth":{"value":"100241241456389.0000000000000"},"block_updated":7237010,"address":"0x577a5b3bf1d36c4280a1c0d9c4513de48fb7ab2e"},{"total_supply_value_in_eth":{"value":"104924149645303.0802967584894"},"total_borrow_value_in_eth":{"value":"71071599057712.00000000000000"},"block_updated":7237040,"address":"0x94e4ad8635617bb984e415b0ac9af757a3274709"},{"total_supply_value_in_eth":{"value":"145321803009.6729246500000000"},"total_borrow_value_in_eth":{"value":"97907798832.62135242500000000"},"block_updated":7237080,"address":"0x0c7f7708dabb9e7b74946dd1275cc96a0f37546c"},{"total_supply_value_in_eth":{"value":"17856866035454094.21282070000"},"total_borrow_value_in_eth":{"value":"11910228509722045.00000000000"},"block_updated":7237040,"address":"0x64abc5b10c77d93be5038e7b4965d2f0d8279127"},{"total_supply_value_in_eth":{"value":"72911723534526066619.80092572"},"total_borrow_value_in_eth":{"value":"48561889166170925093.00000000"},"block_updated":7237057,"address":"0xc534cafac4405402fdba3c253ac930f0451a9e59"},{"total_supply_value_in_eth":{"value":"21996555785937945957.94307287"},"total_borrow_value_in_eth":{"value":"14548444337557905930.00000000"},"block_updated":7236919,"address":"0x8f0d8fda1cb5f0c1b349004042c28e36d505af0e"},{"total_supply_value_in_eth":{"value":"25678483769427204948.66758362"},"total_borrow_value_in_eth":{"value":"16763786811286076317.00000000"},"block_updated":7236919,"address":"0x5104efc872d45dba3a97bf02aebe240dfc283321"},{"total_supply_value_in_eth":{"value":"1544184434299515.529726381784"},"total_borrow_value_in_eth":{"value":"1002262264341560.000000000000"},"block_updated":7237010,"address":"0x404c439cae3208255cb98cabfcef4c4aac03f37e"},{"total_supply_value_in_eth":{"value":"593652257166119270.6407998215"},"total_borrow_value_in_eth":{"value":"375365846957904524.0000000000"},"block_updated":7237062,"address":"0x3f563dd21f42233c4928cad061494f267578b569"},{"total_supply_value_in_eth":{"value":"245085775016562572.4888788411"},"total_borrow_value_in_eth":{"value":"154036963209426155.3654959844"},"block_updated":7237062,"address":"0x047edaf87b0c40b007b7c17f32aca777c6e57f62"},{"total_supply_value_in_eth":{"value":"20589499387569568.46629431221"},"total_borrow_value_in_eth":{"value":"12883388777032501.20327180543"},"block_updated":7237040,"address":"0x38caf77dfe8e588ec4179b8c395644312fc85c49"},{"total_supply_value_in_eth":{"value":"10027567862236449.00000000000"},"total_borrow_value_in_eth":{"value":"6184282148181370.000000000000"},"block_updated":7237040,"address":"0x2774759fec024ec0891566fd31fb8bcbddd40549"},{"total_supply_value_in_eth":{"value":"101133479447661801.0000000000"},"total_borrow_value_in_eth":{"value":"62364773912495697.00000000000"},"block_updated":7237062,"address":"0xb6d1943aad70107c82550ee9651aeb38393abc4a"},{"total_supply_value_in_eth":{"value":"899574543166554142.4032888775"},"total_borrow_value_in_eth":{"value":"551574620202693272.1907856369"},"block_updated":7237062,"address":"0x9b6566e3721e631c8bc5bde603d9e14cb3e73e4b"},{"total_supply_value_in_eth":{"value":"63978724943115815.53441189000"},"total_borrow_value_in_eth":{"value":"39221774871093055.33141664000"},"block_updated":7237062,"address":"0xa7846224a1cf5f63773abe7c5bc3afeafba16655"},{"total_supply_value_in_eth":{"value":"42320289081041652.00000000000"},"total_borrow_value_in_eth":{"value":"25679921249308329.53200896818"},"block_updated":7237056,"address":"0x9910fd08c024dca027671acaba571b2e8aa011eb"},{"total_supply_value_in_eth":{"value":"18376312451272723927.07747522"},"total_borrow_value_in_eth":{"value":"10850491383053097837.07715453"},"block_updated":7236919,"address":"0x07d3642013fde2549e811633f1066910d9c4082f"},{"total_supply_value_in_eth":{"value":"19168027659718232364.67169275"},"total_borrow_value_in_eth":{"value":"11129292192738691294.75098463"},"block_updated":7236919,"address":"0x5d47e871f81f84d3154aec772bcce14973112c69"},{"total_supply_value_in_eth":{"value":"1393266888153929891.792878339"},"total_borrow_value_in_eth":{"value":"800647219105671760.0000000000"},"block_updated":7237062,"address":"0xb1fc19c413f56c387fa6d9a1f15eb7867fa34e1c"},{"total_supply_value_in_eth":{"value":"50042597500517933850.93105234"},"total_borrow_value_in_eth":{"value":"28441344981096353112.88120894"},"block_updated":7237010,"address":"0x1f0cec3a3ee5da9ca9c3d007ceb05adfa3c14cea"},{"total_supply_value_in_eth":{"value":"139077536753238165.3348505391"},"total_borrow_value_in_eth":{"value":"77684784740497774.50480490000"},"block_updated":7237062,"address":"0x80200997f095da94e404f7e0d581aab1ffba9f7d"},{"total_supply_value_in_eth":{"value":"43233519396800105698.00000000"},"total_borrow_value_in_eth":{"value":"24006915688875005379.03547049"},"block_updated":7236919,"address":"0xb3d77ebc988eb7265f8b145accb27bcf2722ee0a"},{"total_supply_value_in_eth":{"value":"3154102877764.000000000000000"},"total_borrow_value_in_eth":{"value":"1739253125042.455579064380423"},"block_updated":7237057,"address":"0x3ac362c27f9490de4ad0f3c8f903713d5ad0d75b"},{"total_supply_value_in_eth":{"value":"1413596010.000000000000000000"},"total_borrow_value_in_eth":{"value":"777951493.063203707500000000"},"block_updated":7237062,"address":"0xecc996953e976a305ee585a9c7bbbcc85d1c467b"},{"total_supply_value_in_eth":{"value":"665075414113219.0000000000000"},"total_borrow_value_in_eth":{"value":"360690456829461.2103987000000"},"block_updated":7237080,"address":"0x7de4bed9c2766a2219f46144d56f372184934cf8"},{"total_supply_value_in_eth":{"value":"92313998384490739.37833629750"},"total_borrow_value_in_eth":{"value":"49773353173057888.20081052472"},"block_updated":7237062,"address":"0xadb2535c3878f7bdf5fbae1491111bbac1bfd18c"},{"total_supply_value_in_eth":{"value":"2061640187499186.813342056429"},"total_borrow_value_in_eth":{"value":"1085225571444324.132340687363"},"block_updated":7237029,"address":"0x8fae89e0f855784c3822a7d915d77dccfffa23ce"},{"total_supply_value_in_eth":{"value":"472405144394.0000000000000000"},"total_borrow_value_in_eth":{"value":"247596447526.2573432400000000"},"block_updated":7237080,"address":"0x00a1b27aba96c12a8e7198a94b83c8a396d90158"},{"total_supply_value_in_eth":{"value":"888789642842372256.5049542825"},"total_borrow_value_in_eth":{"value":"461324363829366533.0000000000"},"block_updated":7237062,"address":"0x3f6033241f355b01d91dc334c77b58270bf0e54d"},{"total_supply_value_in_eth":{"value":"4764207059041832151.807103379"},"total_borrow_value_in_eth":{"value":"2453543366000923778.722710183"},"block_updated":7237062,"address":"0x03b3b1b629907c6e171ea3d3301915a3a5e70470"},{"total_supply_value_in_eth":{"value":"29990903239067538.00000000000"},"total_borrow_value_in_eth":{"value":"15430871013946383.67662543874"},"block_updated":7237051,"address":"0xff49ff8ac9a8d79a6d828391b31a1c753a89f786"}]}
    @Test
    public void testGetAccountValues() {
        String response = api.getAccountValues();
        System.out.println(response);
        Assert.assertNotNull(response);
    }

    //{"error":null,"account_value":{"total_supply_value_in_eth":{"value":"62481637989287.00000000000000"},"total_borrow_value_in_eth":{"value":"42638364754254.00000000000000"},"block_updated":7237417,"address":"0xc88b963239b6918f74c3298bb1dc079b92671e42"}}
    @Test
    public void testGetAccountValue() {
        String response = api.getAccountValue(TEST_ADDRESS);
        System.out.println(response);
        Assert.assertNotNull(response);
    }

}
