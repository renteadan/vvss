/// <reference types="cypress" />

context('Actions', () => {
  beforeEach(() => {
    cy.visit('https://www.cs.ubbcluj.ro')
  });

  it('should search something', () => {
    cy.get('#s')
      .type('something').should('have.value', 'something').type('{enter}');
    cy.url().should('eq', 'https://www.cs.ubbcluj.ro/?s=something');
  })
});