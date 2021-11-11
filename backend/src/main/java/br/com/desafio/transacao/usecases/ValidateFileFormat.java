package br.com.desafio.transacao.usecases;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ValidateFileFormat {

    private final String validFileFormat = "txt";

    public void execute(final @NonNull MultipartFile file) {
        if (!validateFileFormat(file.getOriginalFilename())) {
            throw new RuntimeException("Formato de arquivo inválido!");
        }
    }

    private boolean validateFileFormat(final String filename) {
        final String fileFormat = FilenameUtils.getExtension(filename);
        return validFileFormat.equals(fileFormat);
    }
}
