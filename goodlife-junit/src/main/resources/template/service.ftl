    @Autowired
    private ${method} service;

    @Test
    public void ${method}Test(){
        log.info("传入参数为：{}","${json}");
        try {
            service.${method}()
        }catch (Exception e){
            e.printStackTrace();
        }
    }