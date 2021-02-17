package com.coshmex.store.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.coshmex.store.helper.ExcelHelper;
import com.coshmex.store.mappper.ProductMapper;
import com.coshmex.store.mappper.ProductUniversalMapper;
import com.coshmex.store.model.*;
import com.coshmex.store.repository.FileDBRepository;
import com.coshmex.store.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
  static private Logger logger = LogManager.getLogger(FileStorageService.class);

  @Autowired
  private FileDBRepository fileDBRepository;
  @Autowired
  ProductoFacebookLayoutWriterService productoFacebookLayoutWriterService;

  @Autowired
  private ProductRepository productRepository;

  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    logger.info("entrandos ");
    List<ProductoSyscom>  listaP = ExcelHelper.excelToProducts(file.getInputStream());

    ObjectMapper mapperObj = new ObjectMapper();

    logger.info("ListaPr {} ", listaP.size());
    List<ProductoFacebook> lShop = new ArrayList<>();


    listaP.stream().forEach(
            productoSyscom -> productRepository.save(productoSyscom)
    );

    ProductUniversalMapper mapper = new ProductUniversalMapper();
    lShop=  mapper.mapeaCP(listaP);

    try {
      logger.info(" Escribiendo Archivo {}" , lShop.size());
      this.productoFacebookLayoutWriterService.writeCSV(lShop);

    } catch (CsvDataTypeMismatchException e) {
      e.printStackTrace();
    } catch (CsvRequiredFieldEmptyException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());


    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
