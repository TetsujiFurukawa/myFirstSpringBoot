package com.example.app;

import java.io.InputStream;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class ScannerArgumentResolver implements ArgumentResolver {

  @Override
  public Argument resolve(InputStream is) {
    Scanner scanner = new Scanner(is);

    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();

    return new Argument(a, b);
  }

}
