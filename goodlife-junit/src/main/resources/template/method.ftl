    @Test
    public void ${method}(){
        log.info("传入参数为：{}","${json}");
        try {
            MvcResult mvcResult = mockMvc
                        .perform(
                                MockMvcRequestBuilders.post("${url}")
                                .contentType("${type!'0'}")
                                .content("${json}")
                                )
                                .andReturn();
            int status = mvcResult.getResponse().getStatus();
            String responseString = mvcResult.getResponse().getContentAsString();
            Assert.assertEquals("请求错误", 200, status);
            log.info("返回结果为：{}",responseString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }