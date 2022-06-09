@important
Feature: Create Cart Elevenia
  Penambahan Komputer ke dalam aplikasi web elevenia

  Scenario: : Create Cart as no login
    Given user go to homepage elevenia and search
    When user pick produk Terlaris
    And  user pick produk paling pertama
    And  user add quantity 3 and add to cart
    And  if any question on that popup pick yes
    And  user pick ubah curir
    And  user pick batal
    Then user klik hapus ok