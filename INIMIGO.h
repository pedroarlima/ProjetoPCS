#ifndef INIMIGOH
#define INIMIGOH
#include <string>

using namespace std;

class inimigo
{
  public
    int HitPoints;
    void setHP();
    int getHP();
    void atualizaHP();
    void ColisaoTop();
    void andar();
  
};
