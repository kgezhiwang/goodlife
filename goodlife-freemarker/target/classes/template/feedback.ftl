<?xml version="1.0"?>
<?mso-application progid="Excel.Sheet"?>
<Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:o="urn:schemas-microsoft-com:office:office"
 xmlns:x="urn:schemas-microsoft-com:office:excel"
 xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet"
 xmlns:html="http://www.w3.org/TR/REC-html40">
 <DocumentProperties xmlns="urn:schemas-microsoft-com:office:office">
  <Created>2015-06-05T18:19:34Z</Created>
  <LastSaved>2019-03-25T08:34:01Z</LastSaved>
  <Version>16.00</Version>
 </DocumentProperties>
 <OfficeDocumentSettings xmlns="urn:schemas-microsoft-com:office:office">
  <AllowPNG/>
  <RemovePersonalInformation/>
 </OfficeDocumentSettings>
 <ExcelWorkbook xmlns="urn:schemas-microsoft-com:office:excel">
  <WindowHeight>11160</WindowHeight>
  <WindowWidth>20730</WindowWidth>
  <WindowTopX>32767</WindowTopX>
  <WindowTopY>32767</WindowTopY>
  <ProtectStructure>False</ProtectStructure>
  <ProtectWindows>False</ProtectWindows>
 </ExcelWorkbook>
 <Styles>
  <Style ss:ID="Default" ss:Name="Normal">
   <Alignment ss:Vertical="Bottom"/>
   <Borders/>
   <Font ss:FontName="等线" x:CharSet="134" ss:Size="11" ss:Color="#000000"/>
   <Interior/>
   <NumberFormat/>
   <Protection/>
  </Style>
 </Styles>
 <Worksheet ss:Name="Sheet1">
  <Table ss:ExpandedColumnCount="7" ss:ExpandedRowCount="${size+1}" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
   <Column ss:AutoFitWidth="0" ss:Width="199.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="145.5"/>
   <Column ss:AutoFitWidth="0" ss:Width="135"/>
   <Row>
    <#if type==0>
    <Cell><Data ss:Type="String">时间</Data></Cell>
    <#elseif type==1>
    <Cell><Data ss:Type="String">设备型号</Data></Cell>
    <#elseif type==2>
    <Cell><Data ss:Type="String">时间段</Data></Cell>
    <#elseif type==3>
    <Cell><Data ss:Type="String">地域</Data></Cell>
   </#if>
   <#if type==1>
    <Cell><Data ss:Type="String">设备系统版本</Data></Cell>
  </#if>
    <Cell><Data ss:Type="String">推送总数</Data></Cell>
    <Cell><Data ss:Type="String">收到数</Data></Cell>
    <Cell><Data ss:Type="String">收到率</Data></Cell>
    <Cell><Data ss:Type="String">打开数</Data></Cell>
    <Cell><Data ss:Type="String">打开率</Data></Cell>
   </Row>
   <#list list as f>
   <Row>
    <Cell><Data ss:Type="String">${(f.description)!''}</Data></Cell>
    <#if type==1>
    <Cell><Data ss:Type="String">${(f.sdkVersion)!''}</Data></Cell>
   </#if>
    <Cell><Data ss:Type="String">${f.pushTotalNum?number?string("0%")}</Data></Cell>
    <Cell><Data ss:Type="String">${f.pushReceiveNum?number?string("0%")}</Data></Cell>
    <Cell><Data ss:Type="String">${f.receiveRate?number?string("0%")}</Data></Cell>
    <Cell><Data ss:Type="String">${f.pushOpenNum?number?string("0%")}</Data></Cell>
    <Cell><Data ss:Type="String">${f.pushOpenRate?number?string("0%")}</Data></Cell>
   </Row>
   </#list>
  </Table>
  <WorksheetOptions xmlns="urn:schemas-microsoft-com:office:excel">
   <PageSetup>
    <Header x:Margin="0.3"/>
    <Footer x:Margin="0.3"/>
    <PageMargins x:Bottom="0.75" x:Left="0.7" x:Right="0.7" x:Top="0.75"/>
   </PageSetup>
   <Print>
    <ValidPrinterInfo/>
    <PaperSizeIndex>9</PaperSizeIndex>
    <VerticalResolution>0</VerticalResolution>
   </Print>
   <Selected/>
   <Panes>
    <Pane>
     <Number>3</Number>
     <ActiveRow>11</ActiveRow>
     <ActiveCol>2</ActiveCol>
    </Pane>
   </Panes>
   <ProtectObjects>False</ProtectObjects>
   <ProtectScenarios>False</ProtectScenarios>
  </WorksheetOptions>
 </Worksheet>
</Workbook>
