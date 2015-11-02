#ifndef PERSONAGEMH
#define PERSONAGEMH
#include <string>

using namespace std;

class personagem
{
  private:
    int HitPontos;
    
  public:  
    void setHP();
    int getHP();
    void ColisaoFront();
    void ColisaoBot();
    void andar();
    void pular();
    void ComerBem();
    void ComerMal();
    void AumentaForca();
    void DiminuiuForca();
    void VerificaAlimento();
    
};
