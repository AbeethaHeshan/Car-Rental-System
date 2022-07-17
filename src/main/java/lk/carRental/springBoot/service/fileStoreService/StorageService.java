package lk.carRental.springBoot.service.fileStoreService;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {


    String createDirectory(String newDir,String subDirName);

    void store(String path, MultipartFile... file);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

    void delete(String fileName , String path) throws IOException;
}
